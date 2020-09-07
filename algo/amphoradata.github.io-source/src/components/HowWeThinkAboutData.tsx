import React from "react";
import Link from "@docusaurus/Link";
import { SectionHeader } from "./layout/SectionHeader";

export const HowWeThinkAboutData: React.FC = () => (
    <div className="container text-center">
        <div className="m-5">
            <div className="card card-body m-auto">
                <SectionHeader>How We Think About Data</SectionHeader>
                <p className="font_medium m-auto">
                    Data privacy, governance, and ethics is critical. We operate
                    by the principles of the National Farmers Federation Data
                    Code, the European General Data Protection Regulation, and
                    relevant local laws.
                </p>

                <Link className="font_medium" to="/privacy-security">
                    <div
                        style={{
                            cursor: "pointer",
                            color: "blue",
                        }}
                    >
                        Read our Privacy and Security Policy
                    </div>
                </Link>
            </div>
        </div>
    </div>
);
