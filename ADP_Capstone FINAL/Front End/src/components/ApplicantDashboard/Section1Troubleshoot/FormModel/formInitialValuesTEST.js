import { section1FormModel } from "./section1FormModelTEST";

const {
  formField: {
    employee_Fname,
    employee_Lname,
    employee_MI,
    employee_Oname,
    employee_Address,
    employee_AptNum,
    employee_City,
    employee_State,
    employee_Zip,
    employee_DOB,
    employee_SSN,
    employee_Email,
    employee_Phone,
    employee_Attestation,
    USCISnum,
    expirationDate,
    formI94_AdmissionNum,
    foreignPassportNum,
    countryOfInsuance,
    preparerCert,
    preparerLname,
    preparerFname,
    preparerAddress,
    preparerCity,
    preparerState,
    preparerZip,
    dateCompleted,
    preparerEsign,
  },
} = section1FormModel;

export const formInitialValues = {
  [employee_Fname.name]: "",
  [employee_Lname.name]: "",
  [employee_MI.name]: "",
  [employee_Oname.name]: "",
  [employee_Address.name]: "",
  [employee_AptNum.name]: "",
  [employee_City.name]: "",
  [employee_State.name]: "",
  [employee_Zip.name]: "",
  [employee_DOB.name]: "",
  [employee_SSN.name]: "",
  [employee_Email.name]: "",
  [employee_Phone.name]: "",
  [employee_Attestation.name]: "",
  [USCISnum.name]: "",
  [expirationDate.name]: "",
  [formI94_AdmissionNum.name]: "",
  [foreignPassportNum.name]: "",
  [countryOfInsuance.name]: "",
  [preparerCert.name]: "",
  [preparerLname.name]: "",
  [preparerFname.name]: "",
  [preparerAddress.name]: "",
  [preparerCity.name]: "",
  [preparerState.name]: "",
  [preparerZip.name]: "",
  [dateCompleted.name]: "",
  [preparerEsign.name]: "",
};
