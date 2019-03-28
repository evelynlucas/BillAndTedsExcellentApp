package org.pursuit.billandtedsexcellentapp.network;

import org.pursuit.billandtedsexcellentapp.model.CharactersWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    String ENDPOINT_URL = "evelynlucas/BillAndTedsExcellentApp/master/billandtedjson.json";

    @GET(ENDPOINT_URL)
    Call<CharactersWrapper> getCharacters();
}
