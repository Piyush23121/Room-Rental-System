import logo from './logo.svg';
import './App.css';
import ListLandlordComponent from './Component/ListLandLordComponent';
import Homepage from './Component/HomepageComponent';
import Login from './Component/UserAuthentication/Signin/LoginLandlord';
import LoginLandlord from './Component/UserAuthentication/Signin/LoginLandlord';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Landlord from './Component/Landlord';
import NavigationComponent from './Component/NavigationComponent';
import LoginTenant from './Component/UserAuthentication/Signin/LoginTenant';
import RegisterTenant from './Component/UserAuthentication/Signup/RegisterTenant';
import RegisterLandlord from './Component/UserAuthentication/Signup/RegisterLandlord';
import OwnerProfile from './Component/OwnerDashboard';
import AddProperties from './Component/AddProperties';
import Property from './Component/AddProperties';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NavigationComponent/>
        <Routes>
          <Route path='' element={<Homepage/>} exact />
          <Route path='/home' element={<Homepage/>} exact />
          <Route path='/login/landlord' element= {<LoginLandlord />} />
          <Route path='/login/tenant' element={<LoginTenant/>}/>
          <Route path='/register/tenant' element={<RegisterTenant/>}/>
          <Route path='/register/landlord' element={<RegisterLandlord/>}/>
          <Route path='/landlord/dashboard' element={<OwnerProfile/>}></Route>
          <Route path='/addproperty' element={<Property/>}></Route>
          <Route path='/landlord' element={<Landlord />} />
        </Routes>
      </BrowserRouter>
      {/* <AddProperties/> */}
      {/* <Homepage/> */}
    </div>
  );
}

export default App;
