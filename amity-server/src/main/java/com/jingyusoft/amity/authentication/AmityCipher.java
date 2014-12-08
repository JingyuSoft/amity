package com.jingyusoft.amity.authentication;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.WrappedException;

@Service
public class AmityCipher {

	public static final String PUBLIC_KEY_FILE = "Public.key";

	public static final String PRIVATE_KEY_FILE = "Private.key";

	/**
	 * Encrypt Data
	 *
	 * @param data
	 * @throws IOException
	 */
	public void decryptData(byte[] data) throws IOException {
		System.out.println("\n----------------DECRYPTION STARTED------------");
		byte[] descryptedData = null;

		try {
			PrivateKey privateKey = readPrivateKeyFromFile(PRIVATE_KEY_FILE);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			descryptedData = cipher.doFinal(data);
			System.out.println("Decrypted Data: " + new String(descryptedData));

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("----------------DECRYPTION COMPLETED------------");
	}

	/**
	 * Encrypt Data
	 *
	 * @param data
	 * @throws IOException
	 */
	public byte[] encryptData(String data) throws IOException {
		System.out.println("\n----------------ENCRYPTION STARTED------------");

		System.out.println("Data Before Encryption :" + data);
		byte[] dataToEncrypt = data.getBytes();
		byte[] encryptedData = null;
		try {
			PublicKey pubKey = readPublicKeyFromFile(PUBLIC_KEY_FILE);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			encryptedData = cipher.doFinal(dataToEncrypt);
			System.out.println("Encryted Data: " + encryptedData);

		} catch (Exception e) {
			throw WrappedException.insteadOf(e);
		}

		System.out.println("----------------ENCRYPTION COMPLETED------------");
		return encryptedData;
	}

	/**
	 * read Public Key From File
	 *
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public PrivateKey readPrivateKeyFromFile(String fileName) throws IOException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(new File(fileName));
			ois = new ObjectInputStream(fis);

			BigInteger modulus = (BigInteger) ois.readObject();
			BigInteger exponent = (BigInteger) ois.readObject();

			// Get Private Key
			RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, exponent);
			KeyFactory fact = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = fact.generatePrivate(rsaPrivateKeySpec);

			return privateKey;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				ois.close();
				if (fis != null) {
					fis.close();
				}
			}
		}
		return null;
	}

	/**
	 * read Public Key From File
	 *
	 * @param fileName
	 * @return PublicKey
	 * @throws IOException
	 */
	public PublicKey readPublicKeyFromFile(String fileName) throws IOException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(new File(fileName));
			ois = new ObjectInputStream(fis);

			BigInteger modulus = (BigInteger) ois.readObject();
			BigInteger exponent = (BigInteger) ois.readObject();

			// Get Public Key
			RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, exponent);
			KeyFactory fact = KeyFactory.getInstance("RSA");
			PublicKey publicKey = fact.generatePublic(rsaPublicKeySpec);

			return publicKey;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				ois.close();
				if (fis != null) {
					fis.close();
				}
			}
		}
		return null;
	}

	/**
	 * Save Files
	 *
	 * @param fileName
	 * @param mod
	 * @param exp
	 * @throws IOException
	 */
	public void saveKeys(String fileName, BigInteger mod, BigInteger exp) throws IOException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			System.out.println("Generating " + fileName + "...");
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(new BufferedOutputStream(fos));

			oos.writeObject(mod);
			oos.writeObject(exp);

			System.out.println(fileName + " generated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				oos.close();

				if (fos != null) {
					fos.close();
				}
			}
		}
	}
}
