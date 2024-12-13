package Utilitarios;

import repositorio.CategoriaDao;
import repositorio.FornecedorDao;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.Categoria;
import model.Endereco;
import model.Estoque;
import model.Fornecedor;
import model.PessoaJuridica;
import model.Produto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import static telas.TelaCadastroFornecedor.atualizarBoxTelaProduto;
import telas.TelaCadastroProduto;

public class LeitorProdutoXmlFile {

    private List<Produto> produtosXML = new ArrayList<>();
    private File XML;

    public LeitorProdutoXmlFile(File XML) {
        this.XML = XML;
    }

    public String salvaEmitenteNota() {
        Fornecedor fornecedor = new Fornecedor();
        PessoaJuridica tipo = new PessoaJuridica();
        Endereco endereco = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(XML);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("emit");

            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    tipo.setRazaosocial(eElement.getElementsByTagName("xNome").item(0).getTextContent().trim());
                    tipo.setNomeFantasia(eElement.getElementsByTagName("xFant").item(0).getTextContent().trim());
                    fornecedor.setTelefone(eElement.getElementsByTagName("fone").item(0).getTextContent().trim());
                    tipo.setCnpj(eElement.getElementsByTagName("CNPJ").item(0).getTextContent().trim());
                    tipo.setIe(eElement.getElementsByTagName("IE").item(0).getTextContent().trim());
                    fornecedor.setPessoaJuridica(tipo);

                    endereco = new Endereco(null,
                            eElement.getElementsByTagName("xLgr").item(0).getTextContent().trim(),
                            Integer.parseInt(eElement.getElementsByTagName("nro").item(0).getTextContent().trim()),
                            eElement.getElementsByTagName("xMun").item(0).getTextContent().trim(),
                            eElement.getElementsByTagName("UF").item(0).getTextContent().trim(),
                            eElement.getElementsByTagName("CEP").item(0).getTextContent().trim(),
                            eElement.getElementsByTagName("xBairro").item(0).getTextContent().trim(), "", "PRINCIPAL");

                    endereco.setFornecedor(fornecedor);
                    fornecedor.getEndereco().add(endereco);

                    if (new FornecedorDao().fornecedorByNome(tipo.getRazaosocial()) == null) {
                        new FornecedorDao().cadastra(fornecedor);
                    }
                }
            }

        } catch (SAXException | IOException | ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        }
        return fornecedor.getPessoaJuridica().getRazaosocial();
    }

    public List<Estoque> readXML() throws ParserConfigurationException, SAXException, IOException {

        String nomeFornecedor = salvaEmitenteNota();

        List<Estoque> listaProdutosXML = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(XML);
        doc.getDocumentElement().normalize();

        //System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("prod");

        if (CategoriaDao.categoriaByNome("Importados XML") == null) {
            CategoriaDao.salvaCategoria(new Categoria("Importados XML"));
        }

        FornecedorDao dao = new FornecedorDao();
        if (dao.fornecedorByNome(nomeFornecedor) == null) {
            salvaEmitenteNota();

            if (atualizarBoxTelaProduto) {
                TelaCadastroProduto.setaFornecedoresBox();
                atualizarBoxTelaProduto = false;
            }
        }

        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            System.out.println("\nNode Name :" + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                Produto p = new Produto();
                Estoque e = new Estoque();

                Double qtde = Double.parseDouble(eElement.getElementsByTagName("qCom").item(0).getTextContent().trim());
                p.setCategoria(CategoriaDao.categoriaByNome("Importados XML"));
                p.setDescricao(eElement.getElementsByTagName("xProd").item(0).getTextContent());
                p.setNcm(Integer.parseInt(eElement.getElementsByTagName("NCM").item(0).getTextContent().trim()));
                p.setPreco(new BigDecimal(eElement.getElementsByTagName("vProd").item(0).getTextContent()));
                p.setCodigoBarras(eElement.getElementsByTagName("cProd").item(0).getTextContent());

                p.setComissao(0.0);
                p.setObs("Importado arquivo xml");
                p.setPeso(0.0);
                p.setCapacidade("0");
                p.setReferencia("Nenhuma");
                p.setMarca("Não Informada");

                p.setDimensao("  x  x ");
                p.setFabricao("  /  /  ");
                p.setCor("Incolor");
                p.setPrecoCusto(BigDecimal.ZERO);
                p.setFornecedor(new FornecedorDao().fornecedorByNome(nomeFornecedor));
                // p.setFornecedor(dao.fornecedorByNome("Importador XML"));

                List<Produto> lista = new ArrayList<>();
                lista.add(p);
                e.setUnidade(eElement.getElementsByTagName("uCom").item(0).getTextContent());
                e.setQtdeDisponivel(qtde.intValue());
                e.setMinimo(1);
                e.setProdutos(lista);
                e.setStatus("Disponivel");
                e.setValidade(LocalDate.of(2099, 12, 30));
                e.setLocalizaco("");
                p.setEstoque(e);

                listaProdutosXML.add(e);
            }
        }

        return listaProdutosXML;
    }

}
