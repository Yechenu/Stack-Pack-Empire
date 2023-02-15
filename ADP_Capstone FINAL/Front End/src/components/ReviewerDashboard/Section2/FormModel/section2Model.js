export const section2FormModel = {
  formId: "section2Form",
  formField: {
    applicant_Id: {
      name: "applicant_Id",
      label: "Enter Applicant Id"
    },
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
    employee_Citizenship: {
      name: "employee_Citizenship",
      label: "Citizenship/Immigration Status",
    },
    employee_StartDate: {
      name: "employee_StartDate",
      label: "Employee First Day of Employment",
    },
    document: [
      {
        listCategory: {
          name: "listCategory",
          label: "Select List Category",
        },
        documentTitle: {
          name: "`document.${index}.documentTitle`",
          label: " Document Title",
          //   requiredErrorMsg: "City is required",
        },
        issuingAuthority: {
          name: "`document.${index}.issuingAuthority`",
          label: "Issuing Authority",
        },
        documentNum: {
          name: "`document.${index}.documentNum`",
          label: "Document Number",
        },
        expirationDate: {
          name: "`document.${index}.expirationDate`",
          label: "Expiration Date (if any) (mm/dd/yyyy)",
        },
      },
    ],
    // "document.listCategory": {
    //   name: "employee_Address",
    //   label: " Employee Address (Street Number and Name)",
    //   //   requiredErrorMsg: "City is required",
    // },
    // "document.documentTitle": {
    //   name: "employee_AptNum",
    //   label: "Apt. Number",
    // },
    // "document.issuingAuthority": {
    //   name: "employee_AptNum",
    //   label: "Apt. Number",
    // },
    // "document.documentNum": {
    //   name: "employee_AptNum",
    //   label: "Apt. Number",
    // },
    // "document.expirationDate": {
    //   name: "employee_AptNum",
    //   label: "Apt. Number",
    // },
    additional_Inf: {
      name: "additional_Inf",
      label: "City or Town",
    },
    employee_StartDate: {
      name: "employee_StartDate",
      label: "Employee First Day of Employment",
      requiredErrorMsg: "Date is required",
      invalidErrorMsg: "Date is not valid",
    },

    employer_Lname: {
      name: "employer_Lname",
      label: "Last Name of Employer or Authorized Representative",
      requiredErrorMsg: "Zipcode is required",
      invalidErrorMsg: "Zipcode is not valid (e.g. 70000)",
    },
    employer_Fname: {
      name: "employer_Fname",
      label: "First Name of Employer or Authorized Representative",
    },
    employerTitle: {
      name: "employerTitle",
      label: "Title of Employer or Authorized Representative",
    },
    employer_BusinessName: {
      name: "employer_BusinessName",
      label: "Employer's Business or Organization Name",
      requiredErrorMsg: "Required",
    },
    employer_BusinessAddress: {
      name: "employer_BusinessAddress",
      label:
        "Employer's Business or Organization Address (Street Number and Name ",
    },
    employer_BusinessCity: {
      name: "employer_BusinessCity",
      label: "City or Town",
      requiredErrorMsg: "Required",
    },
    employer_BusinessState: {
      name: "employee_Attestation",
      label: "State ",
      requiredErrorMsg: "Required",
    },
    employer_BusinessZip: {
      name: "employer_BusinessZip",
      label: " ZIP Code",
      requiredErrorMsg: "Required",
    },
    employer_Signature: {
      name: "employerSignature",
      label: "Signature of Employer or Authorized Representative",
      requiredErrorMsg: "Required",
    },

    dateCompleted: {
      name: "dateCompleted",
      label: "Today's Date (mm/dd/yyyy)",
    },
  },
};
