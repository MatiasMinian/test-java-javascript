import React, { Component } from 'react';
import QuotationCardRow from './QuotationCardRow'
import { Toolbar, ToolbarTitle } from 'material-ui/Toolbar';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import theme from 'material-ui/styles/baseThemes/lightBaseTheme';
import { refreshTime } from '../config'
import '../styles/app.scss';

class App extends Component {

    constructor(props) {
        super(props);
        const appState = localStorage.getItem('app');
        if (appState) {
            this.state = JSON.parse(appState)
        } else {
            this.state = { rows: 1 };
            this.saveAppState();
        }
    }

    componentDidMount() {
        setInterval(() => {
            this.setState({ rows: this.state.rows + 1 });
            this.saveAppState();
        }, refreshTime * 1000);
    }

    saveAppState() {
        localStorage.setItem('app', JSON.stringify(this.state));
    }

    render() {
        const rows = [];
        for (let i = 0; i < this.state.rows; i++) {
            rows.push(<QuotationCardRow key={i} id={i} />);
        };

        return (
            <MuiThemeProvider muiTheme={getMuiTheme(theme)}>
                <div>
                    <Toolbar style={{ backgroundColor: '#00E676' }}><ToolbarTitle text='Quotations' /></Toolbar>
                    {rows}
                </div>
            </MuiThemeProvider>
        );
    }
}

export default App;