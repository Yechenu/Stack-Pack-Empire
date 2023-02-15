import Accordion from "react-bootstrap/Accordion";
import Passport from "../../assets/accordion/Passport.png"
import front from "../../assets/accordion/greencard_front.png";
import back from "../../assets/accordion/greencard_back.png";
import frontSig from "../../assets/accordion/greencard_frontsig.png";
import backSig from "../../assets/accordion/greencard_backsig.png";
import waivedFront from "../../assets/accordion/waivedfront.png";
import waivedBack from "../../assets/accordion/waivedBack.png";
import sticker from "../../assets/accordion/sticker.png";
import authFront from "../../assets/accordion/authorizationfront.png";
import authBack from "../../assets/accordion/authorizationback.png";
import passportForeign from "../..//assets/accordion/passportForeign.png";
import customs from "../..//assets/accordion/customs.png";
import alternate from "../../assets/accordion/alternate.png";
import micronesia from "../../assets/accordion/micronesia_passport.png";
import marshall from "../../assets/accordion/marshall_islands.png";
import stapmed from "../../assets/accordion/stamped_passport.png";
import stamp from "../../assets/accordion/stamp.png";
import usPassport from "../../assets/accordion/us_passport.png";
import DriversLicense from "../../assets/accordion/ListB_Documents/missippi_dl.png";
import IdCard from "../../assets/accordion/ListB_Documents/missippi_id.png";
import social from "../../assets/accordion/ListC_Documents/ssn.png";
import abroad from "../../assets/accordion/ListC_Documents/birth_certificate_abroad.png";
import abroadCertificate from "../../assets/accordion/ListC_Documents/birth_certificate_545.png";
import birthReport from "../../assets/accordion/ListC_Documents/birth_report.png";
import seal from "../../assets/accordion/ListC_Documents/seal.png";
import I197 from "../../assets/accordion/ListC_Documents/I-197.png";
import I179 from "../../assets/accordion/ListC_Documents/I-179.png";

function ListItems() {
  return (
    <Accordion className="mt-4 mb-4">
      <Accordion.Item eventKey="0">
        <Accordion.Header>List A Documents</Accordion.Header>
        <Accordion.Body>
          <h6>
            Documents Documents that Establish Both Identity and Employment
            Authorization
          </h6>
          The documents on List A show both identity and employment
          authorization. Employees presenting an acceptable List A document
          should not be asked to present any other document. Some List A
          documents are in fact a combination of 2 or more documents. In these
          cases, the documents presented together count as one List A document.
          <h6>U.S. Passport or U.S. Passport Card</h6>
          <img src={Passport} alt="passport" id="passport" />
          <h6>
            Form I-551, Permanent Resident Card or Alien Registration Receipt
            Card
          </h6>
          <p>
            On May 1, 2017, USCIS began issuing redesigned cards that no longer
            display the individual’s signature. However, some cards issued after
            May 1, 2017, may still display the previous format. Both the
            previous and new cards will remain valid until the expiration date
            shown on the card. These cards are also known as “Green Cards.”
          </p>
          <h6>Permanent Resident Card:</h6>
          <img src={front} alt="greencardfront" id="greencardfront" />
          <img src={back} alt="greencardback" id="greencardback" />
          <p>
            The previous version of the cards was issued after April 30, 2010,
            and may or may not contain a signature. A signature is not required
            for the card to be valid for Form I-9, Employment Eligibility
            Verification.
          </p>
          <h6>Previous Permanent Resident Card with signature:</h6>
          <img src={frontSig} alt="passport" id="passport" />
          <img src={backSig} alt="passport" id="passport" />
          <h6>Permanent Resident Card with notation, "Signature Waived":</h6>
          <img src={waivedFront} alt="waivedFront" />
          <img src={waivedBack} alt="waivedBack" />
          <p>
            Additionally, a Permanent Resident Card with a USCIS-issued sticker
            extending its validity is a List A document and acceptable for Form
            I-9.
          </p>
          <img src={sticker} alt="sticker" />
          <h6>Form I-766, Employment Authorization Document Card</h6>
          USCIS began issuing the current card on May 1, 2017. However, some
          cards issued after May 1, 2017, may still display the previous format.
          Both the previous and new cards will remain valid until the expiration
          date shown on the card.
          <h6>Employment Authorization Document:</h6>
          <img src={authFront} alt="authFront" />
          <img src={authBack} alt="authBack" />
          <h6>
            Foreign passport with Form I-94 or Form I-94A with Arrival-Departure
            Record, and containing an endorsement to work
          </h6>
          <p>
            A foreign passport must be accompanied by a Form I-94/94A
            Arrival-Departure Record bearing the same name as the passport and
            containing an endorsement of the individual’s nonimmigrant status
            and authorization to work for a specific employer based on this
            status. This document may only be used if the period of endorsement
            has not yet expired and the proposed employment does not conflict
            with any restrictions or limitations listed on Form I-94 or I-94A,
            Arrival-Departure Record. Note: Some individuals who present this
            List A document, such as certain nonimmigrant students and exchange
            visitors, must present additional documentation in order to prove
            their work authorization in the U.S. In April 2013, Form I-94 was
            automated at airports and seaports. U.S. Customs and Border
            Protection no longer automatically provides travelers with a paper
            copy of Form I-94. Travelers may access Form I-94 information
            through the U.S. Customs and Border Protection website or may
            request a paper Form I-94 during the inspection process.
          </p>
          <img src={passportForeign} alt="Foreign Passport" />
          <img src={customs} alt="customs" className="mt-2" />
          <img src={alternate} alt="alternate" className="mt-2" />
          <h6>
            Passport from the Federated States of Micronesia (FSM) or the
            Republic of the Marshall Islands (RMI) with Form I-94 or Form I-94A
          </h6>
          <p>
            Passport must be presented with Form I-94 or Form I-94A showing
            nonimmigrant admission under the Compact of Free Association Between
            the U.S. and the FSM or RMI.
          </p>
          <img src={micronesia} alt="Micronesia Passport" className="mt-2" />
          <img
            src={marshall}
            alt="Marshall Islands Passport"
            className="mt-2"
          />
          <h6>
            Foreign passport containing a Form I-551 stamp or Form I-551 printed
            notation
          </h6>
          <p>
            Passport must contain a temporary Form I-551 stamp or temporary Form
            I-551 printed notation on a machine-readable immigrant visa (MRIV).
            This document is subject to reverification.
          </p>
          <img src={stapmed} alt="Stamped Passport" className="mt-2" />
          <img src={stamp} alt="Stamp" className="mt-2" />
          <img src={usPassport} alt="US Passport" className="mt-2" />
        </Accordion.Body>
      </Accordion.Item>
      <Accordion.Item eventKey="1">
        <Accordion.Header>List B Documents</Accordion.Header>
        <Accordion.Body>
          <h6>Documents that Establish Identity</h6>
          <p>
            The documents on List B establish only identity. Employees who
            choose to present a List B document must also present a document
            from List C for Section 2. Employees may present one of the
            following unexpired List B documents:
          </p>

          <h6>Driver's License</h6>
          <p>
            Driver's license or identification card issued by a state or
            outlying territory of the U.S., provided it contains a photograph or
            information such as name, date of birth, gender, height, eye color
            and address.
          </p>
          <img src={DriversLicense} alt="Drivers License" className="mt-2" />
          <img src={IdCard} alt="ID Card" className="mt-2 mb-2" />
          <ul>
            <li>
              ID card issued by federal, state or local government agencies or
              entities, provided it contains a photograph or information such as
              name, date of birth, gender, height, eye color and address
            </li>
            <li>School ID card with a photograph</li>
            <li>Voter registration card</li>
            <li>U.S.military card or draft record</li>
            <li>Military dependent’s ID card</li>
            <li>U.S.Coast Guard Merchant Mariner Document (MMD) card</li>
            <li>Native American tribal document</li>
            <li>Driver’s license issued by a Canadian government authority</li>
          </ul>
          <h6>
            Acceptable List B Documents for individuals under the age of 18 who
            are unable to present a document listed above:
          </h6>
          <ul>
            <li>School record or report card</li>
            <li>Clinic, doctor or hospital record</li>
            <li>Day care or nursery school record</li>
          </ul>

          <p>
            For minors under the age of 18 and certain individuals with
            disabilities who are unable to produce any of the listed identity
            documents, special notations may be used in place of a List B
            document.
          </p>
        </Accordion.Body>
      </Accordion.Item>
      <Accordion.Item eventKey="2">
        <Accordion.Header>List C Documents</Accordion.Header>
        <Accordion.Body>
          <h6>
            The documents in List C only establish employment authorization.
          </h6>
          <p>
            Employees who choose to present a List C document must also provide
            a document from List B, evidence of identity, for Section 2.
          </p>
          <p>
            Employees may present one of the following unexpired List C
            documents:
          </p>
          <h6>U.S. Social Security account number card</h6>
          <p>
            U.S. Social Security account number card that is unrestricted. A
            laminated card is acceptable. A card that includes any of the
            following restrictive wording is not an acceptable List C document:
          </p>
          <ul>
            <li>NOT VALID FOR EMPLOYMENT</li>
            <li>VALID FOR WORK ONLY WITH INS AUTHORIZATION</li>
            <li>VALID FOR WORK ONLY WITH DHS AUTHORIZATION</li>
          </ul>
          <img src={social} alt="ssn card" className="mt-2 mb-2" />
          <h6>Form FS-240, Consular Report of Birth Abroad</h6>
          <img src={abroad} alt="birth certificate" className="mt-2 mb-2" />
          <h6>
            Form FS-545, Certification of Birth Abroad issued by the U.S.
            Department of State
          </h6>
          <img
            src={abroadCertificate}
            alt="abroad birth certificate"
            className="mt-2 mb-2"
          />
          <h6>
            Form DS-1350, Certification of Report of Birth issued by the U.S.
            Department of State
          </h6>
          <img
            src={birthReport}
            alt="abroad birth certificate"
            className="mt-2 mb-2"
          />
          <h6>
            Original or certified copy of a birth certificate issued by a state,
            county, municipal authority or outlying territory of the United
            States bearing an official seal
          </h6>
          <img
            src={seal}
            alt="abroad birth certificate"
            className="mt-2 mb-2"
          />
          <h6>Native American tribal document</h6>
          <h6>Form I-197, U.S. Citizen ID Card</h6>
          <img
            src={I197}
            alt="abroad birth certificate"
            className="mt-2 mb-2"
          />
          <h6>
            Form I-179, Identification Card for Use of Resident Citizen in the
            United States
          </h6>
          <img
            src={I179}
            alt="abroad birth certificate"
            className="mt-2 mb-2"
          />
          <h6>
            Employment authorization document issued by the Department of
            Homeland Security (DHS)
          </h6>
        </Accordion.Body>
      </Accordion.Item>
    </Accordion>
  );
}

export default ListItems;
