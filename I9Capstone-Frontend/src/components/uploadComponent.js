import { PlusOutlined } from "@ant-design/icons";
import { Button, Form, Input, Select, Upload, Space, Breadcrumb } from "antd";
import { Col, Row } from "antd";
//import "./uploadComponent.css";
import { ReactComponent as Image } from "../assets/forms.svg";

//import { useState } from "react";

//Begins code for Upload Component.
function UploadComponent() {
  return (
    <div className="top mt-5">
      {/*<Space direction="vertical horizontal"></Space>*/}
      <Form
        className="form"
        labelCol={{
          span: 4,
        }}
        // wrapperCol={{
        //   span: 14,
        //}}
        layout="horizontal"
      >
        <Row className="mt-5 ms-5">
          <Col>
            <Image />
            <h3 className="ms-2 documents">I-9 Documents</h3>
          </Col>
        </Row>
        <Row className="mt-1 ms-5">
          <Col>
            <Breadcrumb>
              <Breadcrumb.Item>Home</Breadcrumb.Item>
              <Breadcrumb.Item>
                <a href="l">I-9 Documents</a>
              </Breadcrumb.Item>
            </Breadcrumb>
          </Col>
        </Row>
        <Row className="mt-5">
          <Col span={3}></Col>
          <Col span={6}>
            <p>
              For list of valid documents, please view instructions here. {"\n"}{" "}
              After fields have been filled, and files uploaded, select submit
              to send required documents.
            </p>
          </Col>
        </Row>
        <Row className="mt-5">
          <Col span={3}></Col>
          <Col>
            <h5 className="documents">Documents to Send</h5>
          </Col>
        </Row>
        <Row className="mt-4">
          <Col span={4}></Col>
          <Col span={4}>
            <label>
              <strong>List</strong>
            </label>
          </Col>
          <Col span={4} className="ms-4">
            <label>
              <strong>Document Type</strong>
            </label>
          </Col>
          <Col span={4} className="ms-4">
            <label>
              <strong>File</strong>
            </label>
          </Col>
        </Row>

        <Row className="mt-5">
          <Col span={4}></Col>
          <Col span={4}>
            <Form.Item>
              <Select>
                <Select.Option value="demo">List A</Select.Option>
                <Select.Option value="demo">List B</Select.Option>
                <Select.Option value="demo">List C</Select.Option>
              </Select>
            </Form.Item>
          </Col>
          <Col span={4} className="ms-4">
            <Form.Item>
              <Input />
            </Form.Item>
          </Col>
          <Col span={4} className="ms-4">
            <Form.Item valuePropName="fileList">
              <Upload action="/upload.do" listType="button">
                <div>
                  <PlusOutlined />
                  <div
                    style={{
                      marginTop: 2,
                    }}
                  >
                    Upload
                  </div>
                </div>
              </Upload>
            </Form.Item>
          </Col>
        </Row>

        <Row className="mt-2">
          <Col span={4}></Col>
          <Col span={4}>
            <Form.Item>
              <Select>
                <Select.Option value="demo">List A</Select.Option>
                <Select.Option value="demo">List B</Select.Option>
                <Select.Option value="demo">List C</Select.Option>
              </Select>
            </Form.Item>
          </Col>
          <Col span={4} className="ms-4">
            <Form.Item>
              <Input />
            </Form.Item>
          </Col>
          <Col span={4} className="ms-4">
            <Form.Item valuePropName="fileList">
              <Upload action="/upload.do" listType="button">
                <div>
                  <PlusOutlined />
                  <div
                    style={{
                      marginTop: 2,
                    }}
                  >
                    Upload
                  </div>
                </div>
              </Upload>
            </Form.Item>
          </Col>
        </Row>

        <Row className="mt-5">
          <Col span={8}></Col>
          <Col span={6}>
            <Form.Item>
              <Button
                block
                style={{
                  background: "white",
                  borderColor: "2B368A",
                  color: "2B368A",
                  width: "300px",
                }}
              >
                <strong>Submit</strong>
              </Button>
            </Form.Item>
          </Col>
          <Col span={6}>
            <Form.Item>
              <Button
                block
                style={{
                  background: "#2B368A",
                  borderColor: "white",
                  color: "white",
                  width: "300px",
                }}
              >
                <strong>Submit</strong>
              </Button>
            </Form.Item>
          </Col>
        </Row>
      </Form>
    </div>
  );
}
export default UploadComponent;
