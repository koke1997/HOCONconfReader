import React from 'react';
import FileUpload from './components/FileUpload';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>HOCON Configuration File Reader</h1>
      </header>
      <main>
        <FileUpload />
      </main>
    </div>
  );
}

export default App;
