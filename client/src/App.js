import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.scss';
import People from './components/pages/People';
import Popup from './components/views/Popup';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Switch>
          <Route exact path="/">
            <Popup />
          </Route>

          <Route exact path="/people">
            <People />
          </Route>

        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
