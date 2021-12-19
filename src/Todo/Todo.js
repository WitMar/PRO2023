import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const greenStyle = {
    color: 'green',
};

const redStyle = {
    color: 'red',
};


class Todo extends React.Component {
    constructor(props) {
        super(props);
        this.setDone = this.setDone.bind(this);
        this.state = {done: null};
    }

    static getDerivedStateFromProps(props, state) {
        if (state.done === null)
            return {done: props.done}; else return {};
    }

    setDone = () => {
        if (this.state.done) {
            this.setState({done: false}, this.props.update(this.props.id, !this.state.done));
        } else {
            this.setState({done: true}, this.props.update(this.props.id, !this.state.done));
        }
    }


    render() {

        const {value} = this.props;
        const {done} = this.state;

        return (
            <React.Fragment>
                {done === true ?
                    <th style={greenStyle}>
                        {value}
                    </th> :
                    <th style={redStyle}>
                        {value}
                    </th>}
                <th>
                    <button onClick={this.setDone}>
                        Change status
                    </button>
                </th>
            </React.Fragment>
        )

    };
}

export default Todo;