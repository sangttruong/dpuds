const base = "https://app.amphoradata.com/Discover";
const org = "7b429e6c-2885-49cf-994d-4775ae170d64";
const qs = (labels, take) =>
    `Q.OrgId=${org}&Q.Labels=${labels}&Q.Take=${take || 100}&handler=MapView`;

export const products = [
    {
        title: "Crop performance tracking from high-res NDVI",
        imageUrl: "img/26_Kings_rd_NDVI_180220.png",
        description: ` Tracking of performance through 0.5M resolution NDVI images.
                Options include ranking of plants, tracking change in
                performance between image captures and overall crop performance.
                Available now for any global location upon request from $0.7 per
                Ha per month.`,
        link: `${base}?${qs("NDVI")}`,
    },
    {
        title: "Forest vegetation tracking",
        imageUrl: "img/Forest_image.PNG",
        description: `Tracking of forest coverage, extant, and health through remote
                imaging. Available now for any global location upon request from
                $0.05 per Ha per month.`,
    },
];
