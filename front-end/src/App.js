import React from 'react';

import './App.css';
import Layout from './components/LayOut/Layout';
import {BrowserRouter} from 'react-router-dom';



function App() {
  return (
    <div>
      <BrowserRouter>
      <Layout />
      </BrowserRouter>
    </div>
  );
}

export default App;
