import React from 'react';

const greenStyle = {
    color: 'green',
};

const redStyle = {
    color: 'red',
};


function Todo(props) {
    return (
        props.done === true ?
            <li style={greenStyle} >
                {props.value}
            </li> :
            <li style={redStyle} >
                {props.value}
            </li>
    );
}

export default Todo;