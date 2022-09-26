package com.labor.spring.system.ppp.api.gallery;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.labor.common.constants.CommonConstants;
import com.labor.common.exception.ServiceException;

import com.labor.common.util.FileUtil;
import com.labor.common.util.ImageUtil;
import com.labor.common.util.StringUtil;
import com.labor.common.util.TokenUtil;
import com.labor.spring.feign.ObjectMapperUtil;
import com.labor.spring.feign.api.service.FeignOSSService;
import com.labor.spring.feign.oss.ObjectStorageUtil;
import com.labor.spring.system.ppp.ApplicationProperties;
import com.labor.spring.system.ppp.HanLPExtractor;
import com.labor.spring.system.ppp.api.tag.TagServiceIntf;
import com.labor.spring.system.ppp.entity.gallery.Gallery;
import com.labor.spring.system.ppp.entity.gallery.GalleryImage;
import com.labor.spring.util.IgnorePropertiesUtil;
import com.labor.spring.util.WebUtil;
import com.labor.spring.bean.Result;
import com.labor.spring.bean.ResultStatus;

@Service
public class GalleryServiceImpl implements GalleryServiceIntf {
	@Autowired
	private ApplicationProperties properties;
	@Autowired
	private GalleryRepository galleryRepository;
	@Autowired
	private GalleryImageRepository galleryImageRepository;
	@Autowired
	private FeignOSSService feignOSSService;

	@Override
	@Transactional
	public Gallery create(Gallery entity) {
		Gallery ret = null;
		if (entity != null) {
			entity.setId(null);
//			entity.setStatus(CommonConstants.ACTIVE);
			entity.setUuid(TokenUtil.generateUUID());
			if (entity.getName() != null) {
				entity.setNamePinyin(HanLPExtractor.pinyin(entity.getName()));
			}
			return galleryRepository.save(entity);
		}
		return ret;
	}

	@Override
	@Transactional
	public Gallery update(Integer id, Gallery entity, boolean ignoreNullProperties) {
		Gallery newEntity = entity;
		Optional<Gallery> optional = galleryRepository.findOneById(id);
		if (optional.isPresent()) {
			newEntity = optional.get();
			if (ignoreNullProperties) {
				BeanUtils.copyProperties(entity, newEntity, IgnorePropertiesUtil.getNullPropertyNames(entity));
			}
			if (newEntity.getName() != null) {
				newEntity.setNamePinyin(HanLPExtractor.pinyin(newEntity.getName()));
			}
			return galleryRepository.save(newEntity);
		}
		return null;
	}

//	@Override
//	@Transactional
//	public Gallery createImages(Integer galleryId, MultipartFile[] files, Integer startOrder) {
//		Gallery ret = null;
//		Optional<Gallery> optional = galleryRepository.findOneById(galleryId);
//		if (optional.isPresent()){
//			ret = optional.get();
//			startOrder = (startOrder==null)?0:startOrder;
//			if (files!=null&&files.length>0) {
//				int size = files.length;
//				for (int i=0;i<size;i++) {
//					ObjectHeader oh = objectStorageService.create(files[i]);
//					if (oh!=null) {
//						GalleryImage gi = new GalleryImage();
//						gi.setGaId(galleryId);
//						gi.setOhFileName(oh.getFileName());
//						gi.setOhId(oh.getId());
//						startOrder++;
//						gi.setOrder(startOrder);
//						gi.setUuid(TokenUtil.generateUUID());
//						gi.setStatus(CommonConstants.ACTIVE);
//						galleryImageRepository.save(gi);
//					}
//				}
//			}
//		}
//
//		return ret;
//	}

	@Override
	@Transactional
	public GalleryImage createImage(Integer galleryId, MultipartFile file, Integer startOrder) {
		GalleryImage ret = null;
		Optional<Gallery> optional = galleryRepository.findOneById(galleryId);
		if (optional.isPresent()) {

			startOrder = (startOrder == null) ? 0 : startOrder;
			HashMap hm = null;
			Result result = feignOSSService.createImage(file);
			if (ResultStatus.SUCCESS.code()==result.getCode()) {
				hm  = ObjectMapperUtil.getObjectMapper()
						.convertValue(result.getData(),HashMap.class);
			}
			if (hm!=null) {
				GalleryImage gi = new GalleryImage();
				gi.setGaId(galleryId);
				gi.setFileName(StringUtil.safeToString(hm.get("fileName")));
				gi.setOhId(Integer.parseInt(StringUtil.safeToString(hm.get("id"))));
				gi.setOrder(startOrder);
				gi.setUuid(TokenUtil.generateUUID());
				gi.setStatus(CommonConstants.ACTIVE);
				ret = galleryImageRepository.save(gi);
			}
		}

		return ret;
	}
	
	@Override
	@Transactional
	public GalleryImage createImage(Integer galleryId, GalleryImage galleryImage, Integer startOrder) {
		GalleryImage ret = null;
		Optional<Gallery> optional = galleryRepository.findOneById(galleryId);
		if (optional.isPresent()&&galleryImage!=null) {
			startOrder = (startOrder == null) ? 0 : startOrder;
			galleryImage.setGaId(galleryId);
			galleryImage.setOrder(startOrder);
			galleryImage.setUuid(TokenUtil.generateUUID());
			galleryImage.setStatus(CommonConstants.ACTIVE);
			ret = galleryImageRepository.save(galleryImage);
		}
		return ret;
	}
	@Override
	@Transactional
	public GalleryImage updateImage(Integer galleryId, Integer galleryImageId, GalleryImage entity,
			boolean ignoreNullProperties) {
		GalleryImage newEntity = entity;
		Optional<GalleryImage> optional = galleryImageRepository.findOneById(galleryImageId);
		if (optional.isPresent()) {
			if (ignoreNullProperties) {
				newEntity = optional.get();
				BeanUtils.copyProperties(entity, newEntity, IgnorePropertiesUtil.getNullPropertyNames(entity));
			}
			newEntity.setGaId(galleryId);
			if (newEntity.getName() != null) {
				newEntity.setNamePinyin(HanLPExtractor.pinyin(newEntity.getName()));
			}
			return galleryImageRepository.save(newEntity);
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteImage(String uuid) {
		galleryImageRepository.deleteByUuid(uuid);
	}

	@Override
	public Page<Gallery> findList(Pageable pageable) {
		return galleryRepository.findAll(pageable);
	}

	@Override
	public Page<Gallery> findListByExample(Gallery entity, Pageable pageable) {
		Example<Gallery> example = Example.of(entity);
		return galleryRepository.findAll(example, pageable);
	}

	@Override
	public Page<Gallery> findListByNameLike(String name, Pageable pageable) {
		if (StringUtil.isEmpty(name)) {
			return galleryRepository.findAll(pageable);
		}
		return galleryRepository.findByNameContainingIgnoreCaseOrNamePinyinContainingIgnoreCase(name, name, pageable);
	}

	@Override
	public Page<Gallery> findListByNameLikeAndStatus(String name, String status, Pageable pageable) {
		if (StringUtil.isEmpty(name)) {
			if (StringUtil.isEmpty(status)) {
				return galleryRepository.findAll(pageable);
			} else {
				return galleryRepository.findByStatus(status, pageable);
			}
		} else {
			if (StringUtil.isEmpty(status)) {
				return galleryRepository.findByNameContainingIgnoreCaseOrNamePinyinContainingIgnoreCase(name, name,
						pageable);
			} else {
				Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
						new Sort(Sort.Direction.DESC, "ga_id"));
				return galleryRepository.findByNameLikeAndStatus(name, name, status, page);
			}
		}

	}

	@Override
	public List<GalleryImage> findImageListByUuidAndStatusAndCaptionLike(String uuid, String status, String caption) {
		Gallery ga = galleryRepository.findOneByUuid(uuid).orElse(null);
		if (ga == null) {
			return null;
		}
		if (!StringUtil.isEmpty(status)) {
			if (!StringUtil.isEmpty(caption)) {
				return galleryImageRepository.findByGaIdAndStatusAndCaptionContainingIgnoreCase(ga.getId(), status,
						caption);
			} else {
				return galleryImageRepository.findByGaIdAndStatus(ga.getId(), status);
			}

		} else {
			if (!StringUtil.isEmpty(caption)) {
				return galleryImageRepository.findByGaIdAndCaptionContainingIgnoreCase(ga.getId(), caption);
			} else {
				return galleryImageRepository.findByGaId(ga.getId());
			}
		}

	}

	@Override
	public Page<GalleryImage> findImageListByUuidAndStatusAndCaptionLike(String uuid, String status, String caption,
			Pageable pageable) {
		Gallery ga = galleryRepository.findOneByUuid(uuid).orElse(null);
		if (ga == null) {
			return null;
		}
		if (!StringUtil.isEmpty(status)) {
			if (!StringUtil.isEmpty(caption)) {
				return galleryImageRepository.findByGaIdAndStatusAndCaptionContainingIgnoreCase(ga.getId(), status,
						caption, pageable);
			} else {
				return galleryImageRepository.findByGaIdAndStatus(ga.getId(), status, pageable);
			}
		} else {
			return null;
		}
	}

	@Override
	public Optional<Gallery> findById(Integer id) {
		return galleryRepository.findOneById(id);

	}

	@Override
	public Optional<Gallery> findByUuid(String uuid) {
		return galleryRepository.findOneByUuid(uuid);
	}

//	@Override
//	public Optional<Gallery> findByName(String name){
//		return galleryRepository.findFirstByNameOrderByIdDesc(name);
//	}
	
	@Override
	public Optional<GalleryImage> findFistImageByUuid(String uuid) {
		Gallery ga = galleryRepository.findOneByUuid(uuid).orElse(null);
		Integer gaid = 0;
		if (ga != null) {
			gaid = ga.getId();
		}
		return galleryImageRepository.findFirstByGaIdAndStatusOrderByOrderAsc(gaid, CommonConstants.ACTIVE);
	}

	@Override
	public Optional<GalleryImage> findImageByImageUuid(String uuid) {
		return galleryImageRepository.findOneByUuid(uuid);
	}
	
}
