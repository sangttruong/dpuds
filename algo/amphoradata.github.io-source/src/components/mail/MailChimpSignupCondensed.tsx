import * as React from "react";
const hiddenDivStyle: React.CSSProperties = {
    position: "absolute",
    left: "-5000px",
};
import "./mailChimp.css";
export const MailChimpSignupCondensed = () => {
    return (
        <div className="mailchimp-container">
            <link
                href="//cdn-images.mailchimp.com/embedcode/horizontal-slim-10_7.css"
                rel="stylesheet"
                type="text/css"
            />

            <div id="mc_embed_signup">
                <form
                    action="https://amphoradata.us17.list-manage.com/subscribe/post?u=0ace6fc62d5e2c941f7c7127e&amp;id=003b2e58bc"
                    method="post"
                    id="mc-embedded-subscribe-form"
                    name="mc-embedded-subscribe-form"
                    className="validate"
                    target="_blank"
                    noValidate
                >
                    <div id="mc_embed_signup_scroll">
                        <input
                            type="email"
                            defaultValue=""
                            name="EMAIL"
                            className="email"
                            id="mce-EMAIL"
                            placeholder="email address"
                            required
                        />
                        {/* <!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups--> */}
                        <div style={hiddenDivStyle} aria-hidden="true">
                            <input
                                type="text"
                                name="b_0ace6fc62d5e2c941f7c7127e_003b2e58bc"
                                tabIndex={-1}
                                defaultValue=""
                            />
                        </div>
                        <div className="clear">
                            <input
                                value="Subscribe"
                                type="submit"
                                defaultValue="Subscribe"
                                name="subscribe"
                                id="mc-embedded-subscribe"
                                className="button"
                            />
                        </div>
                    </div>
                </form>
            </div>
        </div>
    );
};
