package org.openscience.webcase.core.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ElucidationOptions {
    private String pathToResultsFile;
    private String pathToPyLSDExecutableFolder;
    private String pathToPyLSDInputFileFolder;

    // PyLSD options
    private String pathToLSDFilterList;
    private boolean allowHeteroHeteroBonds;
    private int elimP1;
    private int elimP2;
}
