const base = "https://app.amphoradata.com/Discover";
const org = "7b429e6c-2885-49cf-994d-4775ae170d64";
const qs = (labels, take) =>
    `Q.OrgId=${org}&Q.Labels=${labels}&Q.Take=${take || 100}&handler=MapView`;

export const products = [
    {
        title: "Weather forecasts",
        imageUrl: "img/forecast_image.PNG",
        description: ` 7 day weather forecasts for any location in Australia 100s of
                locations available now for $2 per month. More available on
                request.`,
        link: `${base}?${qs("Forecasts")}`,
    },
    {
        title: "Weather Observations",
        imageUrl: "img/weather_actuals.PNG",
        description: ` Real-time actuals of weather parameters for any location in
                Australia 100s of locations available now for $2 per month. More
                available on request.`,
        link: `${base}?${qs("observations")}`,
    },
    {
        title: "Solar Irradiance",
        imageUrl: "img/solar_image.PNG",
        description: ` Real-time actuals of solar irradiance for any location in
                Australia Any location available on request for $2 per month.`,
        link: `${base}?${qs("solar")}`,
    },
];
