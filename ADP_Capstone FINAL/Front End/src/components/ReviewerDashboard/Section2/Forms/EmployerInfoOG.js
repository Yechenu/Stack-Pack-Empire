// import React from "react";
// import { Formik, Form } from "formik";
// import { formIntitialValues2 } from "../Form Data/formIntitialValues2";
// import { section2Schema } from "../FormModel/section2Schema";
// import CustomInput from "../../../../common/CustomFieldInput";

// const onSubmit = async (_values, actions) => {
//   console.log(JSON.stringify(_values, null, 2));
//   await new Promise((resolve) => setTimeout(resolve, 1000));
//   actions.resetForm();
// };

// function EmployerInfo() {
//   return (
//     <div className="employer-reviewer-containter">
//       EmployerInfo
//       <Formik
//         initialValues={formIntitialValues2}
//         validationSchema={section2Schema}
//         onSubmit={onSubmit}>
//         {/* passes the props from the "CustomFieldInput" file */}
//         {(props) => (
//           <Form>
//             {/*Form section 2 begins*/}
//             {/* Employeee Last Name */}

//             <div className="form_input">
//               <CustomInput
//                 label="Last Name of Reviewer or Authorized Representative"
//                 name=" employer_Lname"
//                 type="text"
//                 placeholder="Enter Last Name"
//               />
//             </div>

//             <div className="form_input">
//               <CustomInput
//                 label=" First Name of Reviewer or Authorized Representative"
//                 name="employer_Fname "
//                 type="text"
//                 placeholder="Enter First Name"
//               />
//             </div>

//             <div className="form_input">
//               <CustomInput
//                 label=" Title of Employer or Authorized Representative"
//                 name="employer_Title"
//                 type="text"
//                 placeholder="Employer's Title is required"
//               />
//             </div>

//             <div className="form_input">
//               <CustomInput
//                 label="Employer's Business or Organization Name"
//                 name="employer_BusinessName:  "
//                 type="text"
//                 placeholder="Enter Citizenship/Immigration Status"
//                 requiredErrorMsg="Employer's Business Name is required"
//               />
//             </div>

//             <div className="form_input">
//               <CustomInput
//                 label="Employer's Business or Organization Address (Street Number and Name)"
//                 name="employer_BusinessAddress "
//                 type="text"
//                 placeholder="Enter Business address"
//                 requiredErrorMsg="Employer's Business Name"
//               />
//             </div>

//             <div className="form_input">
//               <CustomInput
//                 label="City or Town"
//                 name="employer_BusinessCity "
//                 type="text"
//                 placeholder="Enter city"
//                 requiredErrorMsg="Employer's Business city"
//               />
//             </div>

//             <div className="form_input">
//               <CustomInput
//                 label="State"
//                 name="employer_BusinessState  "
//                 type="text"
//                 placeholder="Enter state"
//               />
//             </div>

//             <div className="form_input">
//               <CustomInput
//                 label="ZipCode"
//                 name="employer_BusinessZip  "
//                 type="text"
//                 placeholder="Enter zipcode"
//               />
//             </div>

//             <div className="form_input">
//               <CustomInput
//                 label="Today's Date (yyyy-MM-DD)"
//                 name="dateCompleted  "
//                 type="date"
//               />
//             </div>

//             <div className="form_input">
//               <CustomInput
//                 label="Signature of Employer or Authorized Representative"
//                 name="employerSignature  "
//                 type="string"
//                 placeholder="Signature"
//               />
//             </div>
//           </Form>
//         )}
//       </Formik>
//     </div>
//   );
// }

// export default EmployerInfo;
