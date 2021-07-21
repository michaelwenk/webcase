/*
 * MIT License
 *
 * Copyright (c) 2020 Michael Wenk (https://github.com/michaelwenk)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.openscience.webcase.dbservice.dataset.nmrshiftdb.service;

import casekit.nmr.model.DataSet;
import org.openscience.webcase.dbservice.dataset.nmrshiftdb.model.DataSetRecord;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DataSetServiceImplementation
        implements DataSetService {

    private final DataSetRepository dataSetRepository;

    public DataSetServiceImplementation(final DataSetRepository dataSetRepository) {
        this.dataSetRepository = dataSetRepository;
    }

    @Override
    public Mono<Long> count() {
        return this.dataSetRepository.count();
    }

    @Override
    public Flux<DataSet> findAll() {
        return this.dataSetRepository.findAll()
                                     .map(DataSetRecord::getDataSet);
    }

    @Override
    public Mono<DataSet> findById(final String id) {
        return this.dataSetRepository.findById(id)
                                     .map(DataSetRecord::getDataSet);
    }

    @Override
    public Flux<DataSet> findByMf(final String mf) {
        return this.dataSetRepository.findByMf(mf)
                                     .map(DataSetRecord::getDataSet);
    }

    @Override
    public Flux<DataSet> findByDataSetSpectrumNuclei(final String[] nuclei) {
        return this.dataSetRepository.findByDataSetSpectrumNuclei(nuclei)
                                     .map(DataSetRecord::getDataSet);
    }

    @Override
    public Flux<DataSet> findByDataSetSpectrumNucleiAndDataSetSpectrumSignalCount(final String[] nuclei,
                                                                                  final int signalCount) {
        return this.dataSetRepository.findByDataSetSpectrumNucleiAndDataSetSpectrumSignalCount(nuclei, signalCount)
                                     .map(DataSetRecord::getDataSet);
    }

    @Override
    public Flux<DataSet> findByDataSetSpectrumNucleiAndDataSetSpectrumSignalCountAndMf(final String[] nuclei,
                                                                                       final int signalCount,
                                                                                       final String mf) {
        return this.dataSetRepository.findByDataSetSpectrumNucleiAndDataSetSpectrumSignalCountAndMf(nuclei, signalCount,
                                                                                                    mf)
                                     .map(DataSetRecord::getDataSet);
    }

    // insertions/deletions

    @Override
    public Mono<DataSetRecord> insert(final DataSetRecord dataSetRecord) {
        return this.dataSetRepository.insert(dataSetRecord);
    }

    @Override
    public Mono<Void> deleteAll() {
        return this.dataSetRepository.deleteAll();
    }
}
