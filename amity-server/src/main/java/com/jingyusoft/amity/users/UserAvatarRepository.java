package com.jingyusoft.amity.users;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.WrappedException;

@Repository
public class UserAvatarRepository {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Value("${amity.user.avatar.folder}")
	private String avatarFolder;

	@Value("${amity.user.avatar.filename.prefix}")
	private String fileNamePrefix;

	@Value("${amity.user.avatar.filename.postfix}")
	private String fileNamePostfix;

	public boolean avatarFileExists(long amityUserId) {
		return new File(getAvatarFileName(amityUserId)).exists();
	}

	public byte[] getAvatar(long amityUserId) {
		File file = new File(getAvatarFileName(amityUserId));
		try {
			return FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		}
	}

	private String getAvatarFileName(long amityUserId) {
		return avatarFolder + IOUtils.DIR_SEPARATOR + fileNamePrefix + amityUserId + fileNamePostfix;
	}

	public String saveAvatar(long amityUserId, byte[] avatar) {
		File file = new File(getAvatarFileName(amityUserId));
		if (file.exists()) {
			try {
				FileUtils.forceDelete(file);
				LOGGER.info("Existing avatar file [{}] deleted for user [{}]", file.getName(), amityUserId);
			} catch (IOException e) {
				throw WrappedException.insteadOf(e);
			}
		}

		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(avatar);
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		}

		LOGGER.info("New avatar file saved as [{}] for user [{}]", file.getName(), amityUserId);

		return file.getName();
	}
}
