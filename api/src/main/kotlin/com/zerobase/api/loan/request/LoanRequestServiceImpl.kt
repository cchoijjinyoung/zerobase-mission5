package com.zerobase.api.loan.request

import com.zerobase.api.loan.GenerateKey
import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository

class LoanRequestServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository
): LoanRequestService {
    override fun loanRequestMain(loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {
        val userKey = generateKey.generateUserKey()

        saveUserInfo(loanRequestInputDto.toUserInfoDto(userKey))

        loanRequestReview("")
        return null;
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        userInfoRepository.save(userInfoDto.toEntity())


    override fun loanRequestReview(userKey: String) {
        TODO("Not yet implemented")
    }
}