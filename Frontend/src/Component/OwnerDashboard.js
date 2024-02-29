import React, { useState } from 'react';
import AddProperties from './AddProperties'
import { Link } from 'react-router-dom';
const OwnerProfile = () => {
  // Sample user data
  const [user] = useState({
    name: 'John Doe',
    email: 'john@example.com'
  });

  // State to toggle visibility of property tables
  const [showAddProperties, setShowAddProperties] = useState(false);
  const [showExistingProperties, setShowExistingProperties] = useState(false);

  function addproperty(){
    return <>
    <AddProperties/>
    </>
  }
  return (
    <div style={{ textAlign: 'center' }}>
      <h2>Dashboard</h2>
      <div style={{ margin: 'auto', width: '50%' }}>
        <p><strong>Name:</strong> {user.name}</p>
        <p><strong>Email:</strong> {user.email}</p>
        <div>
          {/* <button className="btn btn-dark" style={{ marginRight: '10px' }} onClick={}>Add New Properties</button> */}
          <Link className="btn btn-dark" to="/addproperty" style={{  }}> <a className="nav-link" href="#">Add Property</a></Link>
          <button className="btn btn-dark" onClick={() => setShowExistingProperties(!showExistingProperties)}>Existing Properties</button>
        </div>
        {showAddProperties && (
          <div>
            <h3>Add Properties</h3>
            {/* Table for adding properties */}
            <table style={{ margin: 'auto' }}>
              {/* Table headers */}
              <thead>
                <tr>
                  <th>Property Name</th>
                  <th>Property Value</th>
                </tr>
              </thead>
              {/* Table body */}
              <tbody>
                {/* Table rows for adding properties */}
                <tr>
                  <td>Property 1</td>
                  <td>Value 1</td>
                </tr>
                <tr>
                  <td>Property 2</td>
                  <td>Value 2</td>
                </tr>
                {/* Add more rows as needed */}
              </tbody>
            </table>
          </div>
        )}
        {showExistingProperties && (
          <div>
            <h3>Existing Properties</h3>
            {/* Table for existing properties */}
            <table style={{ margin: 'auto' }}>
              {/* Table headers */}
              <thead>
                <tr>
                  <th>Property Name</th>
                  <th>Property Value</th>
                </tr>
              </thead>
              {/* Table body */}
              <tbody>
                {/* Table rows for existing properties */}
                <tr>
                  <td>Existing Property 1</td>
                  <td>Existing Value 1</td>
                </tr>
                <tr>
                  <td>Existing Property 2</td>
                  <td>Existing Value 2</td>
                </tr>
                {/* Add more rows as needed */}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
};

export default OwnerProfile;
