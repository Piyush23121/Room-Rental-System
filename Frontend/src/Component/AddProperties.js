import React, { useState } from "react";
import '../Resources/CSS/PropertyDetails.css';

const Property = () => {
    const [state, setState] = useState({
        list_property: [],
        selectedcity: "",
        selectedarea: "",
        selectedstate: "",
        selectedrent: "",
        selectedstatus: "",
        selectedPropertyType: "",
        selectedfacilities: "",
        selectedaddress: "",
        selectedpincode: ""
    });

    const handleChnage = (e) => {
        e.preventDefault();
        const input = e.target;
        const nm = input.name;
        const val = input.value;
        console.log(val);
        setState(prevState => ({ ...prevState, [nm]: val }));
    }

    const submitList = (e) => {
        e.preventDefault();
        alert("Your property has been listed successfully");
    }

    const { list_property } = state;

    if (list_property.length === 0) {
        return (
            <div className="cont">
                <div className="container">
                    <div className="row">
                        <div className="col-4"></div>
                        <div className="col-4">
                            <div className="card text-center">
                                <div className="card-body">
                                    <center>
                                        <form className="Property-details">
                                            <div className="row align-items-center">
                                                <h2 style={{ color: 'black', fontSize: '30px', paddingTop: '20px' }}><b>PropertyDetails</b></h2>

                                                <div className="mb-3">
                                                    <select className="form-select" required aria-label="select example" name="selectedcity" onChange={handleChnage}>
                                                        <option selected disabled value="">select City</option>
                                                        <option value="pune">Pune</option>
                                                        <option value="mumbai">Mumbai</option>
                                                        <option value="nashik">Nashik</option>
                                                        <option value="ahmedabad">Ahmedabad</option>
                                                    </select>
                                                </div>

                                                {/* ... (Rest of the form elements) ... */}

                                                <div className="mb-3 facility fs-5">
                                                    <label htmlFor="facilities">Facilities : </label>
                                                    <input type="checkbox" name="facilities" placeholder="Facilities" value="wifi" onChange={handleChnage} /> Wifi
                                                    <input type="checkbox" name="facilities" placeholder="Facilities" value="parking" onChange={handleChnage} /> Parking
                                                </div>
                                                <div>
                                                    <button type="submit" className="btn btn-success" value='submit' onClick={submitList}><b>Save & Continue</b></button>
                                                </div>
                                            </div>
                                        </form>
                                    </center>
                                </div>
                            </div>
                        </div>
                        <div className="col-4"></div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Property;
