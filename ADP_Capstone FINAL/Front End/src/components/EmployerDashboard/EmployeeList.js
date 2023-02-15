import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";

const instance = new EmployeeService();

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    getAllEmployees();
  }, []);

  const getAllEmployees = () => {
    instance
      .getAllEmployees()
      .then((response) => {
        setEmployees(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const deleteEmployee = (employeeId) => {
    instance
      .deleteEmployee(employeeId)
      .then((response) => {
        getAllEmployees();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container mt-4">
      <h2 className="text-center">Employee List</h2>
      <Link to="/add-employee" className="btn btn-primary mb-2">
        {" "}
        Add Employee{" "}
      </Link>
      <table className="table table-bordered table-striped">
        <thead>
          <th>Employee ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Job Title</th>
          <th>Email</th>
          <th>Address</th>
          <th>State</th>
          <th>Zipcode</th>
          <th>Country</th>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td> {employee.id} </td>
              <td> {employee.firstName} </td>
              <td>{employee.lastName}</td>
              <td>{employee.job_title}</td>
              <td>{employee.email}</td>
              <td>{employee.address}</td>
              <td>{employee.state}</td>
              <td>{employee.zipcode}</td>
              <td>{employee.country}</td>
              <td>
                <Link
                  className="btn btn-info"
                  to={`/edit-employee/${employee.id}`}>
                  Update
                </Link>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteEmployee(employee.id)}
                  style={{ marginLeft: "10px" }}>
                  {" "}
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
