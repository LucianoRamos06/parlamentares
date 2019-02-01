<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Detalhas do Parlamentar</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="contact-area" style="text-align: center">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="contact-list">
                                    <div style="text-align: center">
                                        <img style="width: 200px; text-align: center" src="${parlamentar?.urlFoto ?: "http://cacimbinhas.al.gov.br/images/sem_foto_m.png"}" alt="" />
                                    </div>

                                    <div class="contact-ctn">
                                        <div class="contact-ad-hd">
                                            <h2>${parlamentar?.nome}</h2>
                                            <p><b>Data de Nasciemento: </b>${g.formatDate(format: 'dd/MM/yyy', date: parlamentar?.dataNascimento)}</p>
                                            <p><b>Sexo: </b>${parlamentar?.sexo == 'M' ? 'Masculino' : 'Feminino'}</p>
                                            <p><b>Patido: </b>${parlamentar?.partido?.sigla + ' - ' + parlamentar?.partido?.nome}</p>
                                            <p><b>Legislatura Atual: </b>${parlamentar?.situacaoNaLegislaturaAtual}</p>
                                            <p><b>Nome: </b>${parlamentar?.partido?.nome}</p>
                                            <p><b>Fone: </b>${parlamentar?.contato?.fone}</p>
                                            <p><b>e-mail: </b>${parlamentar?.contato?.email}</p>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>