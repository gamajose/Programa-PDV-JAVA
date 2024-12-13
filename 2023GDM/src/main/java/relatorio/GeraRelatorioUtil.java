package relatorio;

import Utilitarios.FabricaConexao;
import repositorio.ClienteDao;
import repositorio.EmpresaDao;
import repositorio.PedidoDao;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.view.JasperViewer;

public class GeraRelatorioUtil {

    public void geraReletorioVendasEfetuadas(long codigoVenda, long codCliente) {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/Danfe.jrxml");
        try {
            Map<String, Object> params = new HashMap<>();

            EmpresaDao emp = new EmpresaDao();
            PedidoDao pedidoDao = new PedidoDao();

            params.put("nomeEmpresa",
                    emp.dadosDaEmpresa()
                            .getPessoaJuridica()
                            .getNomeFantasia());

//            //dados da venda
            params.put("codigo", codigoVenda);
            params.put("logo", emp.dadosDaEmpresa().getFotoLogo());

//            //dados do cliente
            try {
                if (codCliente != 0L) {
                    params.put("nomeCliente", new ClienteDao()
                            .clientePorCodigo(codCliente)
                            .getPessoaJuridica()
                            .getNomeFantasia()
                            .toUpperCase());
                }
            } catch (NoResultException e) {
                params.put("nomeCliente", "Cliente não informado");
            }
            JasperReport jasperReport = JasperCompileManager.compileReport(rel);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, FabricaConexao.getConexao());
            jasperPrint.setOrientation(OrientationEnum.LANDSCAPE);
            JasperViewer j = new JasperViewer(jasperPrint, false);
            j.setAlwaysOnTop(true);
            j.setTitle("Pedido");
            j.setVisible(true);

            j.setFitPageZoomRatio();
            j.setFitWidthZoomRatio();

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void geraReletorioPedidoEfetuado(long codigo) {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/pedido.jrxml");
        try {
            Map<String, Object> params = new HashMap<>();

            EmpresaDao emp = new EmpresaDao();
            PedidoDao pedidoDao = new PedidoDao();

            params.put("nomeEmpresa",
                    emp.dadosDaEmpresa()
                            .getPessoaJuridica()
                            .getNomeFantasia());

            //dados da empresa
            params.put("CODIGO", codigo);
            params.put("logo", emp.dadosDaEmpresa().getFotoLogo());
            params.put("bairro", emp.dadosDaEmpresa().getEnderecos().get(0).getBairro().toUpperCase());
            params.put("cidade", emp.dadosDaEmpresa().getEnderecos().get(0).getCidade().toUpperCase());
            params.put("endereco", emp.dadosDaEmpresa().getEnderecos().get(0).getEndereco().toUpperCase());
            params.put("cep", emp.dadosDaEmpresa().getEnderecos().get(0).getCep());
            params.put("uf", emp.dadosDaEmpresa().getEnderecos().get(0).getUf());
            params.put("numero", emp.dadosDaEmpresa().getEnderecos().get(0).getNumero());

            //dados do cliente
            params.put("nomeCliente", pedidoDao.pedidoPorCodigo(codigo).getCliente().getPessoaJuridica().getNomeFantasia().toUpperCase());
            params.put("clienteCpf", pedidoDao.pedidoPorCodigo(codigo).getCliente().getCpf());
            params.put("clienteCnpj", pedidoDao.pedidoPorCodigo(codigo).getCliente().getPessoaJuridica().getCnpj());
            params.put("contato", pedidoDao.pedidoPorCodigo(codigo).getCliente().getCelular());

            JasperReport jasperReport = JasperCompileManager.compileReport(rel);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, FabricaConexao.getConexao());
            jasperPrint.setOrientation(OrientationEnum.LANDSCAPE);
            JasperViewer j = new JasperViewer(jasperPrint, false);
            j.setAlwaysOnTop(true);
            j.setTitle("Pedido");
            j.setVisible(true);

            j.setFitPageZoomRatio();
            j.setFitWidthZoomRatio();

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void geraReletorioCaixaGeral(LocalDate data1, LocalDate data2) {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/caixaGeralDiario.jrxml");
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("data1", data1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            params.put("data2", data2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

//            List<Produto> lista = new ArrayList<>();
//            Produto p =  new Produto();
//            p.setDescricao("descricao");
//            p.setCor("Azul");
//            lista.add(p);
//            
//            
//            JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(lista);
//            params.put("itens",datasource);
//            params.put("nomeEmpresa",
//                    new EmpresaDao()
//                            .dadosDaEmpresa()
//                            .getPessoaJuridica()
//                            .getNomeFantasia());
//
//            params.put("CODIGO", codigo);
            // params.put("CLIENTE",)
            JasperReport jasperReport = JasperCompileManager.compileReport(rel);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, FabricaConexao.getConexao());
            jasperPrint.setOrientation(OrientationEnum.PORTRAIT);
            JasperViewer j = new JasperViewer(jasperPrint, false);
            j.setAlwaysOnTop(true);
            j.setTitle("Fluxo");
            j.setVisible(true);

            j.setFitPageZoomRatio();
            j.setFitWidthZoomRatio();

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void geraReletorioProdutosServicos() {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/ProdutoServicos.jrxml");
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("data1", "");
            params.put("data2", "");

            JasperReport jasperReport = JasperCompileManager.compileReport(rel);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, FabricaConexao.getConexao());
            jasperPrint.setOrientation(OrientationEnum.PORTRAIT);
            JasperViewer j = new JasperViewer(jasperPrint, false);
            j.setAlwaysOnTop(true);
            j.setTitle("Cadastros");
            j.setVisible(true);

            j.setFitPageZoomRatio();
            j.setFitWidthZoomRatio();

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void geraReletorioPedidoOrcamento(long codigo) {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/Orcamento.jrxml");
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("codigoPedido", codigo);
            params.put("tipoPedido", "ORÇAMENTO");

            JasperReport jasperReport = JasperCompileManager.compileReport(rel);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, FabricaConexao.getConexao());
            jasperPrint.setOrientation(OrientationEnum.PORTRAIT);
            JasperViewer j = new JasperViewer(jasperPrint, false);
            j.setAlwaysOnTop(true);
            j.setTitle("Orçamento");
            j.setVisible(true);

            j.setFitPageZoomRatio();
            j.setFitWidthZoomRatio();

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public static void main(String[] args) {
        GeraRelatorioUtil g = new GeraRelatorioUtil();
        //  g.geraReletorioPedidoEfetuado(2L);
        // g.geraReletorioCaixaGeral();
    }

}
