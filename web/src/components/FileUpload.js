import React, { useState } from 'react';
import axios from 'axios';
import ParsedResults from './ParsedResults';

const FileUpload = () => {
  const [file, setFile] = useState(null);
  const [parsedResults, setParsedResults] = useState(null);

  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };

  const handleUpload = async () => {
    if (!file) {
      alert('Please select a file first!');
      return;
    }

    const formData = new FormData();
    formData.append('file', file);

    try {
      const response = await axios.post('/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      setParsedResults(response.data);
    } catch (error) {
      console.error('Error uploading file:', error);
      alert('Error uploading file. Please try again.');
    }
  };

  return (
    <div>
      <input type="file" onChange={handleFileChange} />
      <button onClick={handleUpload}>Upload</button>
      {parsedResults && <ParsedResults results={parsedResults} />}
    </div>
  );
};

export default FileUpload;
