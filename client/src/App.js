import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.scss';
import People from './components/pages/People';
import Person from './components/pages/Person';
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

          <Route exact path="/person/:id">
            <Person />
          </Route>

        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
