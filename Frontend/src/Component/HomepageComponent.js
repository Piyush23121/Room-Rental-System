import React, { useEffect, useState } from 'react';
import ListLandlordComponent from './ListLandLordComponent';
import "../Resources/CSS/Homepage.css"
import { getarea } from "../Service/property.service"

const Homepage = () => {
 return( <main>
  <h1 className="head">Welcome</h1>
  <div className="Location">
    <div className="city">
      <select>
        <option selected disabled value="">select City</option>
        <option value="pune">Pune</option>
        <option value="mumbai">Mumbai</option>
        <option value="nashik">Nashik</option>
        <option value="ahmedabad">Ahmedabad</option>
      </select>
      <select>
        <option selected disabled value="">select Area</option>
        <option value="deccan">Pune-Deccan</option>
        <option value="hinjewadi">Pune-Hinjewadi</option>
        <option value="kothrud">Pune-Kothrud</option>
        <option value="karvenagar">Pune-Karve Nagar</option>
        <option value="shivajinagar">Pune-Shivaji Nagar</option>
        <option value="vileparle">Mumbai-Vile Parle</option>
        <option value="andherieast">Mumbai-Andher East</option>
        <option value="andheriwest">Mumbai-Andheri West</option>
        <option value="juhu">Mumbai-Juhu</option>
        <option value="gangapurroad">Nashik-Gangapur Road</option>
        <option value="collegeroad">Nashik-College Road</option>
        <option value="mahatmanagar">Nashik-Mahatma Nagar</option>
        <option value="ashoknagar">Nashik-Ashok Nagar</option>
        <option value="thaltej">Ahmedabad-Thaltej</option>
        <option value="bopal">Ahmedabad-Bopal</option>
        <option value="sghighway">Ahmedabad-SG Highway</option>
        <option value="motera">Ahmedabad-Motera</option>
        <option value="ladldarwaja">Ahmedabad-Lal Darwaja</option>
      </select>
      <div className="search" >
        <span>
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-search" viewBox="0 0 16 16">
            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
          </svg>
          Search
        </span>
      </div>
    </div>
    <div className="house">
      <div><input type="radio" name="one" id="house" /><label htmlFor="house">Full House</label></div>
      <div><input type="radio" name="one" id="pg" /><label htmlFor="pg">PG/Hostel</label></div>
      {/* <div><input type="radio" name="one" id="flat"/><label htmlFor="flat">Flatmates</label></div> */}
      <select>
        <option selected value="">Availability</option>
        <option>Immediate</option>
        <option>Within 7 days</option>
        <option>Within 15 days</option>
        <option>Within 30 days</option>
      </select>
    </div>
  </div>
  {/* <div className="low">
  ------- Are you a Property Owner? ---------
</div> */}


</main>);
};

export default Homepage;
