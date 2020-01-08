
import Todos from './components/Todos';
import React, { Component } from 'react';

import './App.css';
import Header from './components/layout/Header';
import Add from './components/Add';

class App extends Component {
  state = {
    todos : [
      {
        id:1,
        title : 'Take out trash',
        completed : false 
      },
      {
        id:2,
        title : 'dinner with wife',
        completed : true 
      },
      {
        id:3,
        title : 'meeting with boss',
        completed : false 
      },
    ]
  }
  markComplete = (id) =>{
    this.setState({todos: this.state.todos.map(todo =>{
      if(todo.id === id){
        todo.completed = !todo.completed
      }
      return todo;
    })});
  }
  deleteTodo=(id) =>{
    this.setState({todos : [...this.state.todos.filter(todo =>todo.id !== id)]});
  }
  render(){
  console.log(this.state.todos)
  return (
    <div className="App">
     <div className="container">
      <Header />
      <Add />
      <Todos todos={this.state.todos} markComplete={this.markComplete} deleteTodo ={this.deleteTodo}/>
      </div>
    </div>
  );
}
}
export default App;
