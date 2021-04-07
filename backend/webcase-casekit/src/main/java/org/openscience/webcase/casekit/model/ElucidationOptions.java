package org.openscience.webcase.casekit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElucidationOptions {
    private String pathToResultsFile;
    private String pathToPyLSDExecutableFolder;
    private String pathToPyLSDInputFile;
    private String pathToPyLSDInputFileFolder;

    // PyLSD options
    private String pathToLSDFilterList;
    private boolean allowHeteroHeteroBonds;
    private int elimP1;
    private int elimP2;
}
