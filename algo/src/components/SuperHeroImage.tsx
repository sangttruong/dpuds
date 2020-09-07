import React from "react";
interface SuperHeroImageProps {
    className: string;
}

const outerStyle: React.CSSProperties = {
    textAlign: "center",
    position: "relative",
    overflow: "hidden",
    background: "url('/img/network.jpg')",
    backgroundSize: "cover",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    flexDirection: "column",
};

export const SuperHeroImageSection: React.FC<SuperHeroImageProps> = (props) => (
    <div style={outerStyle}>
        <div className="row opacity-container p-2">
            <div className="col justify-content-center">
                <div className="font_extra_large w-75 text-center m-auto">
                    Amphora Data connects owners and users of the world's
                    real-time information
                </div>

                <img
                    src="/img/Home_page_image.png"
                    alt="Benefits of Amphora"
                    width="80%"
                />
            </div>
        </div>
    </div>
);
