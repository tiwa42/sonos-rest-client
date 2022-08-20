package de.tiwa42.sonosrestclient;

class AuthCredentials {
    private final String clientId;
    private final String redirectUri;
    private final String state;
    private final String clientSecret;

    public AuthCredentials(String clientId, String redirectUri, String state, String clientSecret) {
        this.clientId = clientId;
        this.redirectUri = redirectUri;
        this.state = state;
        this.clientSecret = clientSecret;
    }

    String getLoginUrl() {
        return "https://api.sonos.com/login/v3/oauth?client_id=" + clientId + "" +
                "&response_type=code&state=" + state + "" +
                "&scope=playback-control-all&redirect_uri=" + redirectUri + "'";
    }
}
