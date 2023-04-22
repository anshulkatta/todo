import React from 'react';
import './App.css';
import TodoBrowser from 'src/todo-browser/TodoBrowser'

function App() {
  return (
    <div className="App">
      <p>Todo App</p>
      <header className="App-header">
        <TodoBrowser/>
      </header>
    </div>
  );
}

export default App;
