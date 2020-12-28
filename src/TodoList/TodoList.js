import React from 'react';
import styled from 'styled-components';
import Todo from "../Todo/Todo";

const greenStyle = {
    color: 'green',
};

const Undone = styled.li`
  color: red;
`;

class TodoList extends React.Component {
    render() {
        return (
            <div className="TodoList">
                <h1>Todo List {this.props.name}</h1>
                <ul>
                    <li style={greenStyle}>Learn React</li>
                    <Undone>Pass Programming Laboratoty</Undone>
                    <Todo value ="Have a nice holiday"
                          done = {false}   />
                </ul>
            </div>
        );
    }
}

export default TodoList;


