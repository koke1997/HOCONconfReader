import pyhocon
from typing import Set

def parse_config(file_path: str) -> Set[str]:
    config = pyhocon.ConfigFactory.parse_file(file_path)
    return get_all_keys(config)

def get_all_keys(config, parent_key: str = "") -> Set[str]:
    keys = set()
    for key, value in config.items():
        full_key = f"{parent_key}.{key}" if parent_key else key
        if isinstance(value, pyhocon.config_tree.ConfigTree):
            keys.update(get_all_keys(value, full_key))
        else:
            keys.add(full_key)
    return keys
