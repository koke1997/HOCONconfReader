import unittest
from HOCONParser import parse_config

class TestHOCONParser(unittest.TestCase):

    def test_parse_config(self):
        file_path = "src/test/resources/test.conf"
        expected_keys = {
            "included.settingA",
            "included.settingB",
            "main.setting1",
            "main.setting2"
        }
        result = parse_config(file_path)
        self.assertEqual(result, expected_keys)

    def test_parse_included_config(self):
        file_path = "src/test/resources/test.conf"
        expected_keys = {
            "included.settingA",
            "included.settingB",
            "main.setting1",
            "main.setting2"
        }
        result = parse_config(file_path)
        self.assertEqual(result, expected_keys)

if __name__ == "__main__":
    unittest.main()
