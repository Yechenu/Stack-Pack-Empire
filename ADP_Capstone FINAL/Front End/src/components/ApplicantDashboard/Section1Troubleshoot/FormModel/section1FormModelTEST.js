export const section1FormModel = {
  formId: "section1Form",
  formField: {
    employee_Fname: {
      name: "employee_Fname",
      label: "Employee First Name (Given Name) ",
      requiredErrorMsg: "First name is required",
    },
    employee_Lname: {
      name: "employee_Lname",
      label: "Employee Last Name (Family Name)",
      requiredErrorMsg: "Last name is required",
    },
    employee_MI: {
      name: "employee_MI",
      label: "Employee Middle Initial",
      requiredErrorMsg: "Middle name is required",
    },
    employee_Oname: {
      name: "employee_Oname",
      label: "Employee Other Last Names Used (if any)",
    },
    employee_Address: {
      name: "employee_Address",
      label: " Employee Address (Street Number and Name)",
      //   requiredErrorMsg: "City is required",
    },
    employee_AptNum: {
      name: "employee_AptNum",
      label: "Apt. Number",
    },
    employee_City: {
      name: "employee_City",
      label: "City or Town",
    },
    employee_State: {
      name: "employee_State",
      label: "State/Province/Region",
    },
    employee_Zip: {
      name: "employee_Zip",
      label: "Zipcode*",
      requiredErrorMsg: "Zipcode is required",
      invalidErrorMsg: "Zipcode is not valid (e.g. 70000)",
    },
    employee_DOB: {
      name: "employee_DOB",
      label: "Date of Birth (mm/dd/yyyy)",
      requiredErrorMsg: "Date of Birth  is required",
      invalidErrorMsg: "Date of Birth  is not valid",
    },
    employee_SSN: {
      name: "employee_SSN",
      label: "U.S. Social Security Number",
    },
    employee_Email: {
      name: "employee_Email",
      label: "Employee's E-mail Address",
      requiredErrorMsg: "Email is required",
      invalidErrorMsg: "Email is not valid",
    },
    employee_Phone: {
      name: "employee_Phone",
      label: "Employee's Telephone Number",
      requiredErrorMsg: "Telephone Number is required",
      invalidErrorMsg: "Telephone Number is not valid",
    },
    employee_Attestation: {
      name: "employee_Attestation",
      label: "Select one of the following ",
      requiredErrorMsg: "Attestation is required",
    },
    USCISnum: {
      name: "USCISnum",
      label: " Alien Registration Number/USCIS Number",
      requiredErrorMsg: "USCIS number is required",
    },
    expirationDate: {
      name: "expirationDate",
      label: "Expiration date, if applicable, mm/dd/yyyy",
      requiredErrorMsg: "Expiry date is required",
      invalidErrorMsg: "Expiry date is not valid",
    },
    formI94_AdmissionNum: {
      name: "formI94_AdmissionNum",
      label: " Form I-94 Admission Number",
    },
    foreignPassportNum: {
      name: "foreignPassportNum",
      label: "Foreign Passport Number*",
    },
    countryOfInsuance: {
      name: "countryOfInsurance",
      label: "Country of Insuance",
      requiredErrorMsg: "Country of Insuance* is required",
    },
    employee_Signature: {
      name: "employee_Signature",
      label: "Signature of Employee",
      required: "Signature is required",
    },
    preparerCert: {
      name: "preparerCert",
      label: "Preparer and/or Translator Certification *",
      requiredErrorMsg: "Required",
    },
    preparerLname: {
      name: "preparerLname",
      label: "Last Name (Family Name)",
    },
    preparerFname: {
      name: "preparerFname",
      label: "First Name (Given Name)",
    },
    preparerAddress: {
      name: "preparerAddress",
      label: "Address (Street Number and Name)",
    },
    preparerCity: {
      name: "preparerCity",
      label: "City or Town",
    },
    preparerState: {
      name: "preparerState",
      label: "State",
    },
    preparerZip: {
      name: "PreparerZip",
      label: "ZIP Code",
    },
    dateCompleted: {
      name: "dateCompleted",
      label: "Today's Date (mm/dd/yyyy)",
    },
    preparerEsign: {
      name: "preparerEsign",
      label: "Signature of Preparer or Translator",
    },
  },
};
