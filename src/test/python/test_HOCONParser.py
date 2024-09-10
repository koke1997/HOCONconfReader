import unittest
from HOCONParser import parse_config

class TestHOCONParser(unittest.TestCase):

    def test_parse_config(self):
        print("Starting test: test_parse_config")  # P584c
        file_path = "src/test/resources/test.conf"
        expected_keys = {
            "included.settingA",
            "included.settingB",
            "main.setting1",
            "main.setting2"
        }
        print(f"Expected keys: {expected_keys}")  # P9267
        result = parse_config(file_path)
        print(f"Result: {result}")  # Pc795
        self.assertEqual(result, expected_keys)
        print("Finished test: test_parse_config")  # Pd1a8

    def test_parse_included_config(self):
        print("Starting test: test_parse_included_config")  # P584c
        file_path = "src/test/resources/test.conf"
        expected_keys = {
            "included.settingA",
            "included.settingB",
            "main.setting1",
            "main.setting2"
        }
        print(f"Expected keys: {expected_keys}")  # P9267
        result = parse_config(file_path)
        print(f"Result: {result}")  # Pc795
        self.assertEqual(result, expected_keys)
        print("Finished test: test_parse_included_config")  # Pd1a8

if __name__ == "__main__":
    unittest.main()
