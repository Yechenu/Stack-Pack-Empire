import { section2FormModel } from "./section2Model";

const {
  formField: {
    applicant_Id,
    employee_Fname,
    employee_Lname,
    employee_MI,
    employee_Citizenship,
document:[ {
 listCategory,
    documentTitle,
    issuingAuthority,
    documentNum,
    expirationDate
}],
   

    //   'document.documentTitle':"",
    //  ' document.issuingAuthority',
    //   'document.documentNum',
    //  ' document.expirationDate',
    additional_Inf,
    employee_StartDate,

    employer_Lname,
    employer_Fname,
    employerTitle,
    employer_BusinessName,
    employer_BusinessAddress,
    employer_BusinessCity,
    employer_BusinessState,
    employer_BusinessZip,
    employer_Signature,
    dateCompleted,
  },
} = section2FormModel;

export const formInitialValues = {
  [applicant_Id.name]: "",
  [employee_Fname.name]: "",
  [employee_Lname.name]: "",
  [employee_MI.name]: "",
  [employee_Citizenship.name]: "",

  [listCategory.name]: "",
  [documentTitle.name]: "",
  [issuingAuthority.name]: "",
  [documentNum.name]: "",
  [expirationDate.name]: "",

  [additional_Inf.name]: "",
  [employee_StartDate.name]: "",
  [employer_Lname.name]: "",
  [employer_Fname.name]: "",
  [employerTitle.name]: "",
  [employer_BusinessName.name]: "",
  [employer_BusinessAddress.name]: "",
  [employer_BusinessCity.name]: "",
  [employer_BusinessState.name]: "",
  [employer_BusinessZip.name]: "",
  [employer_Signature.name]: "",
  [dateCompleted.name]: "",
};
