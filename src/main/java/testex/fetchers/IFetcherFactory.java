/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex.fetchers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kasper
 */
public interface IFetcherFactory {
    
    
    public ArrayList<IJokeFetcher> getFetchers(String jokeTypes);
    
    public List<String> getAvailableTypes();
}
