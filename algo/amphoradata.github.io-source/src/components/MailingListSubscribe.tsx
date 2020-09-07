import React from "react";
import { SectionHeader } from "./layout/SectionHeader";
import Link from "@docusaurus/Link";

import useBaseUrl from "@docusaurus/useBaseUrl";
import { MailChimpSignupCondensed } from "./mail/MailChimpSignupCondensed";

export const MailingListSubscribeSection = (props) => (
    <React.Fragment>
        <div className="row mt-5">
            <div className="col text-center">
                <SectionHeader>
                    Want the latest on finding, sharing and using data?
                </SectionHeader>
                <p className="font_medium">
                    Subscribe to our mailing list
                    <MailChimpSignupCondensed />
                </p>

                <p className="font_medium">
                    {"Give us a call at +61 7 3172 9948 or "}
                    <Link
                        className="font_medium"
                        to={useBaseUrl("mailto:contact@amphoradata.com")}
                    >
                        email us directly.
                    </Link>
                </p>
            </div>
        </div>
    </React.Fragment>
);
