import React from 'react';
import './App.css';
import TodoBrowser from 'src/todo-browser/TodoBrowser'

function App() {
  return (
    <>
      <h1 className="text-3xl text-primary text-center">
        Todo
      </h1>
      <div className='p-6 max-w-sm mx-auto bg-white rounded-xl shadow-lg flex items-center space-x-4'>
        <TodoBrowser />
      </div>
    </>
  );
}

export default App;
