package org.pursuit.billandtedsexcellentapp.model;

import java.util.List;

public class CharactersWrapper {

    private List<CharacterModel> characters;

    public List<CharacterModel> getCharacters() {
        return characters;
    }

    public class CharacterModel {

        private String name, bio, quote, image, url;

        public String getName() {
            return name;
        }

        public String getBio() {
            return bio;
        }

        public String getQuote() {
            return quote;
        }

        public String getImage() {
            return image;
        }

        public String getUrl() {
            return url;
        }
    }
}
