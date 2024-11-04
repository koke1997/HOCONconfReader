const express = require('express');
const multer = require('multer');
const { exec } = require('child_process');
const path = require('path');

const app = express();
const port = 5000;

const upload = multer({ dest: 'uploads/' });

app.post('/upload', upload.single('file'), (req, res) => {
  const filePath = path.join(__dirname, req.file.path);

  exec(`scala -cp "lib/*" com.example.FileSelector ${filePath}`, (error, stdout, stderr) => {
    if (error) {
      console.error(`Error executing Scala code: ${error.message}`);
      return res.status(500).json({ error: 'Error parsing file' });
    }

    if (stderr) {
      console.error(`Scala stderr: ${stderr}`);
      return res.status(500).json({ error: 'Error parsing file' });
    }

    const parsedResults = parseScalaOutput(stdout);
    res.json(parsedResults);
  });
});

function parseScalaOutput(output) {
  const lines = output.split('\n');
  const results = {};

  lines.forEach(line => {
    const [key, value] = line.split(': ');
    if (key && value) {
      results[key] = value;
    }
  });

  return results;
}

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
