import React from 'react';
import TodoList from "../TodoList/TodoList";

class List extends React.Component {
    render() {
        return <TodoList name="My List of Todo tasks" />;
    }
}

export default List;