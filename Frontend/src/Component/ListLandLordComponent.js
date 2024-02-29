import React,{useEffect, useState} from "react";
import { listlandlord } from "../Service/landlord.service";

const ListLandlordComponent = () => {
    // const [landlord,setLandlord] = useState([])
    // useEffect(()=>{
    //     listlandlord().then((response)=>{
    //         setLandlord(response.data);
    //     }).catch((err)=>{
    //         console.log(err);
    //     })
    // },[])

    return(
        <div>
            <h3>Landlord Details</h3>
            <table className="table">
                <thead className="thead-dark">
                    <tr>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Email Id</td>
                        <td>Phone No.</td>
                    </tr>
                </thead>
                {/* <tbody>
                    {
                        landlord.map(owner=>
                            <tr key={owner.ownerId}>
                                <td>{owner.firstName}</td>
                                <td>{owner.lastName}</td>
                                <td>{owner.emailId}</td>
                                <td>{owner.phone}</td>
                            </tr>
                            )
                    }
                </tbody> */}
            </table>
        </div>
    )
}
export default ListLandlordComponent;