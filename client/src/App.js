import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.scss';
import Popup from './components/views/Popup';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Switch>
          <Route exact path="/">
            <Popup />
          </Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
