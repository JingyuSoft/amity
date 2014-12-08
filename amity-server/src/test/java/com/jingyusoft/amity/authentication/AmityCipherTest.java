package com.jingyusoft.amity.authentication;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.jingyusoft.amity.common.WrappedException;

@RunWith(BlockJUnit4ClassRunner.class)
public class AmityCipherTest {

	@Resource
	private AmityCipher amityCipher;

	@Test
	public void test() {
		try {
			System.out.println("-------GENRATE PUBLIC and PRIVATE KEY-------------");
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048); // 1024 used for normal securities
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			System.out.println("Public Key - " + publicKey);
			System.out.println("Private Key - " + privateKey);

			// Pullingout parameters which makes up Key
			System.out.println("\n------- PULLING OUT PARAMETERS WHICH MAKES KEYPAIR----------\n");
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec rsaPubKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			RSAPrivateKeySpec rsaPrivKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
			System.out.println("PubKey Modulus : " + rsaPubKeySpec.getModulus());
			System.out.println("PubKey Exponent : " + rsaPubKeySpec.getPublicExponent());
			System.out.println("PrivKey Modulus : " + rsaPrivKeySpec.getModulus());
			System.out.println("PrivKey Exponent : " + rsaPrivKeySpec.getPrivateExponent());

			// Share public key with other so they can encrypt data and decrypt thoses using private key(Don't share
			// with Other)
			System.out.println("\n--------SAVING PUBLIC KEY AND PRIVATE KEY TO FILES-------\n");
			AmityCipher rsaObj = new AmityCipher();
			rsaObj.saveKeys(AmityCipher.PUBLIC_KEY_FILE, rsaPubKeySpec.getModulus(), rsaPubKeySpec.getPublicExponent());
			rsaObj.saveKeys(AmityCipher.PRIVATE_KEY_FILE, rsaPrivKeySpec.getModulus(),
					rsaPrivKeySpec.getPrivateExponent());

			// Encrypt Data using Public Key
			byte[] encryptedData = rsaObj.encryptData("Plain Text to be Encrypted");

			// Descypt Data using Private Key
			rsaObj.decryptData(encryptedData);

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw WrappedException.insteadOf(e);
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
