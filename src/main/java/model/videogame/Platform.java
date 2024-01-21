package model.videogame;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Platform {
  private PlatformInfo platform;

    public Platform( ) {

    }

    public PlatformInfo getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformInfo platform) {
        this.platform = platform;
    }
}