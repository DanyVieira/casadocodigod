package br.com.casadocodigod.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component //componente do spring 
public class FileSaver {

	@Autowired //para o sprng injetar o request
	private HttpServletRequest request;//pega a requisição

	public String write(String baseFolder, //recebe o local onde ira guardar o arquivo
			MultipartFile file) { //recebe o próprio arquivo
		try {
			 String realPath=request.getServletContext().getRealPath("/"+baseFolder);//aqui pega o local exato do servidor pra salvar o arq no local certo
			 //getRealPath pega o caminho de uma determinada pasta informada
			String path = realPath +"/"+file.getOriginalFilename();
			file.transferTo(new File(path));//faz a transferencia do arq 
			
			return baseFolder +"/"+file.getOriginalFilename();
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
