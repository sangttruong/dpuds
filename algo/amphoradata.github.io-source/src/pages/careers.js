import React from "react";
import Layout from "@theme/Layout";
import classnames from "classnames";
import styles from "./styles.module.css";

function Careers() {
    return (
        <Layout title="Careers">
            <div className="container container--fluid">
                <div
                    className="row p-4"
                    className={classnames("hero", styles.heroBanner)}
                >
                    <h2
                        className="font_large text--white"
                        style={{
                            paddingLeft: "240px",
                            paddingRight: "240px",
                            paddingTop: "120px",
                            paddingBottom: "60px",
                        }}
                    >
                        Our people are our core capability. We offer our team
                        members a constructive culture, remote-work, competitive
                        packages, and lots of development.
                    </h2>
                </div>

                <div
                    className={classnames("row", styles.justifyContentCenter)}
                    style={{ paddingTop: "60px" }}
                >
                    <div className="col">
                        <h3 className="font_large text--center">
                            We don't have any positions currently open.
                        </h3>
                    </div>
                </div>
            </div>
        </Layout>
    );
}

export default Careers;
